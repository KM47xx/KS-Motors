  document.addEventListener("DOMContentLoaded", function () {
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
    const urlParams = new URLSearchParams(window.location.search);
    const currentType = urlParams.get("type");

    const links = document.querySelectorAll("nav a");

    links.forEach((link) => {
      const linkParams = new URLSearchParams(link.search);
      const linkType = linkParams.get("type");

      if (linkType === currentType) {
        link.classList.add("active");
      }
    });
  }
window.addEventListener("DOMContentLoaded", highlightActiveLink);

