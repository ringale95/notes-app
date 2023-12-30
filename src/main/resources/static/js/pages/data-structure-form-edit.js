
import { makeRequest } from '../common/api.js';
import { showToast } from "../common/toast.js";

// Check if the current URL contains "/signup"
if (window.location.pathname.includes('/data-structures/') && window.location.pathname.includes('/edit')) {
  document.addEventListener('DOMContentLoaded', () => {
	

	// Configure Quill Editor
	const quill = configureQuillEditor();
	
    // Attach the onSubmit function to the button click event
    const form = document.getElementById('data-structure-form-edit');
    if (form) {
      form.addEventListener('submit', () => onUpdate(event, quill));
    }
    
  });
}

const onUpdate = (event, quill) => {
  // Prevent the default form submission
  event.preventDefault();
  
  // Setup Quill Editor text to Form's input
  document.getElementById('hidden-notes').value = quill.root.innerHTML;

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

const configureQuillEditor = () => {
    const quill = new Quill('#quill-editor', {
            theme: 'snow',
            modules: {
                toolbar: [
                    ['bold', 'italic', 'underline', 'strike'],
                    [{ 'code-block': true }], // This adds a button for code block
                    [{ 'header': [1, 2, 3, 4, 5, 6, false] }],
                    ['image'],
                ],
            },
        });
        
	return quill;
}

export { onUpdate };
