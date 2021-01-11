let form = document.getElementById('info-form');
let fname = document.getElementById('fname');
let lname = document.getElementById('lname');
let below18 = document.getElementById('below18');
let e18to60 = document.getElementById('e18to60');
let above60 = document.getElementById('above60');
let state = document.getElementById('state');
let email = document.getElementById('email');

form.addEventListener('submit', (e) => {
  e.preventDefault();

  let resultObj = {};

  console.log('Submitting the form..');

  // for name
  // empty check
  // if (fname.value === "" || lname.value === "") {
  //     alert("Empty Name or last name.");
  //     return;
  // }

  resultObj.FirstName = fname.value.toLowerCase();
  resultObj.LastName = lname.value.toLowerCase();

  //for age group
  if (below18.checked) {
    resultObj.AgeGroup = 'below 18';
  } else if (e18to60.checked) {
    resultObj.AgeGroup = 'between 18 to 60';
  } else if (above60.checked) {
    resultObj.AgeGroup = 'above 60';
  }

  // for state
  if (state.value !== 'na') {
    resultObj.State = state.value.toLowerCase();
  } else {
    alert('Select the state');
    return;
  }

  // email
  resultObj.Email = email.value.toLowerCase();

  // final object
  console.log(resultObj);
});
