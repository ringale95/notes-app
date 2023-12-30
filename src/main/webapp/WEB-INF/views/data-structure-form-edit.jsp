<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/commons" prefix="cm" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Notes</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link href="https://cdn.quilljs.com/1.3.6/quill.snow.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdn.quilljs.com/1.3.6/quill.js"></script>  
    <script src="https://unpkg.com/quill-better-table@1.2.10/dist/quill-better-table.js"></script>    
    <script type="module" src="${pageContext.request.contextPath}/js/index.js"></script>
</head>
<body>
    <cm:header/>
    <div class="container mt-5">
        <form id="data-structure-form-edit">
            <!-- ID Field (Hidden) -->
            <input type="hidden" name="id" value="${structures.id}" />

            <!-- Name Field (Non-editable) -->
            <div class="mb-3">
                <label for="name" class="form-label">Name:</label>
                <input type="text" class="form-control" id="name" name="name" placeholder="Enter your name" value="${structures.name}" readonly>
            </div>

            <!-- Notes Field (Textarea) -->
            <div class="mb-3">
                <label for="notes" class="form-label">Notes:</label>
				<div id="quill-editor" style="height: 300px;">${structures.notes}</div>
                <input type="hidden" id="hidden-notes" name="notes" />            
            </div>

            <!-- Submit Button -->
            <button type="submit" class="btn btn-primary">Update</button>

            <!-- New Button for navigating to /data-structures/${structures.id} -->
            <a href="/data-structures/${structures.id}" class="btn btn-secondary">View Details</a>
        </form>
    </div>
    <script>
        var quill = new Quill('#quill-editor', {
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

        // Update the hidden input with the HTML content when the form is submitted
        document.getElementById('data-structure-form-edit').addEventListener('submit', function () {
            document.getElementById('hidden-notes').value = quill.root.innerHTML;
        });
    </script>
</body>
</html>
