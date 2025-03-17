  document.addEventListener("DOMContentLoaded", function () {
    // Load header
    fetch("header.html")
      .then((response) => {
        if (!response.ok) {
          throw new Error("Failed to load header: " + response.statusText);
        }
        return response.text();
      })
      .then((data) => {
        document.getElementById("header").innerHTML = data;
        highlightActiveLink();
      })
      .catch((error) => {
        console.error(error);
      });
  
    // Load footer
    fetch("footer.html")
      .then((response) => {
        if (!response.ok) {
          throw new Error("Failed to load footer: " + response.statusText);
        }
        return response.text();
      })
      .then((data) => {
        document.getElementById("footer").innerHTML = data;
      })
      .catch((error) => {
        console.error(error);
      });
  });
  function highlightActiveLink() {
    // Get the current page's filename (e.g., "index.html")
    const currentPage = window.location.pathname.split("/").pop();
  
    // Get all links in the header
    const links = document.querySelectorAll("nav a");
  
    // Loop through the links and add the "active" class to the matching link
    links.forEach((link) => {
      const linkHref = link.getAttribute("href");
      if (linkHref === currentPage) {
        link.classList.add("active");
      }
    });
  }