const url = "http://localhost:8080/api/v1/Events";

async function Paginate() {
  try {
    const result = await fetch(url);
    const data = await result.json();
    console.log(data);
  } catch (error) {
    console.log(error);
  }
}

Paginate();
