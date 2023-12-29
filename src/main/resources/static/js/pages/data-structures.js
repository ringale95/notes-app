// notifications.js

import { makeRequest } from "../common/api.js";
import { showToast } from "../common/toast.js";

// Check if the current URL contains "/notifications"
if (window.location.pathname.includes('/data-structures')) {
  document.addEventListener('DOMContentLoaded', function () {
    registerDeleteButtonClick();
  });
}

function registerDeleteButtonClick() {
  // Get all close buttons on the page
  const deleteButtons = document.querySelectorAll('.btn-danger');

  // Attach a click event listener to each close button
  deleteButtons.forEach(function (button) {
    button.addEventListener('click', function () {
      // Extract nId from the button's data attribute or any other suitable method
      const nId = button.dataset.nId;

      // Call the onClose function with nId as a parameter
      onDelete(nId);
    });
  });
}

function onDelete(nId) {
  // Show a confirmation dialog
  const isConfirmed = confirm("Are you sure you want to delete this data structure?");

  // Check if the user confirmed
  if (isConfirmed) {
    makeRequest('api/data-structures/' + nId, 'DELETE', null, onSuccess, () => showToast("Request Failed", "fail"));
  }
}

const onSuccess = () => {
    showToast("Data Structure deleted!!", "success");
    window.location.reload();
}

export { onDelete };
