
import { makeRequest } from '../common/api.js';
import { showToast } from "../common/toast.js";

// Check if the current URL contains "/signup"
if (window.location.pathname.includes('/data-structures/') && window.location.pathname.includes('/edit')) {
  // Use DOMContentLoaded directly in signup.js
  document.addEventListener('DOMContentLoaded', () => {

    // Attach the onSubmit function to the button click event
    const form = document.getElementById('data-structure-form-edit');
    if (form) {
      form.addEventListener('submit', onUpdate);
    }

  });
}

const onUpdate = (event) => {
  // Prevent the default form submission
  event.preventDefault();

  // Fetch Form-data
  const formData = new FormData(event.target);
  const structure = Object.fromEntries(formData.entries());

  // Invoke makeRequest(url, method, formData, onSuccess, onError)
  makeRequest('/api/data-structures/' + structure.id, 'PATCH', structure, onSuccess, onError);

}

// Define the onSuccess and onError functions as needed
const onSuccess = (data) => {
  showToast("Request successful!!", "success");
};

const onError = (error) => {
  showToast("Request Failed", "fail");
};

export { onUpdate };
