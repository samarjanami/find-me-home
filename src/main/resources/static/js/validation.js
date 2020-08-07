function validateForm() {
  var zipCode = document.forms["searchForm"]["location"].value;
  document.getElementById('zipcode-error').innerHTML = '';
  var isValid = (/^\d{5}(-\d{4})?(?!-)$/.test(zipCode));
  if ( zipCode == "" || !isValid) {
    document.getElementById('zipcode-error').innerHTML = 'Please enter valid zip code';
    return false;
  }
}
