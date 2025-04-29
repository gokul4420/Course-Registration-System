function showCourses(){
    fetch("http://localhost:8080/courses") //api end point
    .then((response)=>response.json())
    .then((courses) =>{
        const dataTable=document.getElementById("coursetable")

        courses.forEach(course =>{
            var row=`<tr>
            <td>${course.courseId}</td>
            <td>${course.courseName}</td>
            <td>${course.trainer}</td>
            <td>${course.durationInWeeks}</td>
            </tr>`

            dataTable.innerHTML+=row;

        });
    });
}

window.onload = function () {
  fetchStudents();
};

function goHome() {
  window.location.href = "index.html";
}

function fetchStudents() {
  fetch("http://localhost:8080/courseRegistry")
    .then(response => response.json())
    .then(data => {
      const tableBody = document.getElementById("enrolledtable");
      tableBody.innerHTML = "";

      data.forEach((student, index) => {
        const actualFee = getActualFee(student.courseName);
        const paidAmount = parseFloat(student.coursefee);
        let statusIcon = "";

        // Status update logic based on payment
        if (paidAmount >= actualFee) {
          statusIcon = '<i class="fas fa-check-circle" style="color:green;" title="Paid in full or overpaid"></i>';
        } else if (paidAmount < actualFee && paidAmount > 0) {
          statusIcon = '<i class="fas fa-times-circle" style="color:red;" title="Underpaid"></i>';
        } else {
          statusIcon = '<i class="fas fa-times-circle" style="color:red;" title="No payment made"></i>';
        }

        const row = document.createElement("tr");
        row.innerHTML = `
          <td>${index + 1}</td>
          <td>${student.name}</td>
          <td>${student.emailId}</td>
          <td>${student.courseName}</td>
          <td>₹${paidAmount}</td>
          <td>${statusIcon}</td>
        `;
        tableBody.appendChild(row);
      });
    })
    .catch(error => {
      console.error("Error fetching students:", error);
      const tableBody = document.getElementById("enrolledtable");
      tableBody.innerHTML = "<tr><td colspan='6'>Failed to load students.</td></tr>";
    });
}

function getActualFee(courseName) {
  const courseFees = {
    "Java": 5000,
    "Python": 4500,
    "C++": 4000,
    "Web Development": 5500,
    "Data Science": 6000,
    "React": 4800
  };
  return courseFees[courseName] || 0;
}
  


