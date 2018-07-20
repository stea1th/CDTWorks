// Foursquare API Info
const clientId = 'KBA4PGKUQNKQ113CY35SZT44YEUPAV3SQ5K3UMKOXDJYQELD';
const clientSecret = 'XSZL5ULC2Q511B33G5TPXMSGFUTQ11SSGUVOOG3HMYIJAVV0';
const url = 'https://api.foursquare.com/v2/venues/explore?near=';

// APIXU Info
const apiKey = 'c96c8419718b4190a2584547181707';
const forecastUrl = 'https://api.apixu.com/v1/forecast.json?key=';

// Page Elements
const $input = $('#city');
const $submit = $('#button');
const $destination = $('#destination');
const $container = $('.container');
const $venueDivs = [$("#venue1"), $("#venue2"), $("#venue3"), $("#venue4")];
const $weatherDivs = [$("#weather1"), $("#weather2"), $("#weather3"), $("#weather4")];
const weekDays = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'];

// Add AJAX functions here:
const getVenues = async() => {
  const city = $input.val();
  const urlToFetch = url + city + "&limit=10&client_id="+clientId+"&client_secret=" +clientSecret+"&v=20180717";
  try{
    const response = await fetch(urlToFetch);
    if(response.ok){
      const jsonResponse = await response.json();
      const venues = jsonResponse.response.groups[0].items.map(parameter => parameter.venue);
      console.log(venues);
      return venues;
    }
    
  }catch(error){
    console.log(error);
}

}

const getForecast = async() => {
  const urlToFetch = forecastUrl+apiKey+"&q="+$input.val()+"&days=4&hour=11";
try{
  const response = await fetch(urlToFetch);
  if(response.ok){
    const jsonResponse = await response.json();
    const days = jsonResponse.forecast.forecastday;
    console.log(days);
    return days;
  }
}catch(error){
  console.log(error);
}
}


// Render functions
const renderVenues = (venues) => {
  $venueDivs.forEach(($venue, index) => {
    const venue = venues[index];
    const venueIcon = venue.categories[0].icon;
    console.log(venueIcon);
    const venueImgScr = venueIcon.prefix + 'bg_64' + venueIcon.suffix;

    let venueContent = createVenueHTML(venue.name, venue.location, venueImgScr);
    $venue.append(venueContent);
  });
  $destination.append(`<h2>${venues[0].location.city}</h2>`);
}

const renderForecast = (days) => {
  $weatherDivs.forEach(($day, index) => {
    const currentDay = days[index];
    let weatherContent = createWeatherHTML(currentDay);
    $day.append(weatherContent);
  });
}

const executeSearch = () => {
  $venueDivs.forEach(venue => venue.empty());
  $weatherDivs.forEach(day => day.empty());
  $destination.empty();
  $container.css("visibility", "visible");
  getVenues().then(venues => renderVenues(venues));
  getForecast().then(days => renderForecast(days));
  return false;
}

$submit.click(executeSearch)


