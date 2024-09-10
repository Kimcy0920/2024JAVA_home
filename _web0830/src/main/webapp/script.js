document.getElementById('createForm').addEventListener('submit', function(event) { // index.html - form태그 submit 동작 시 이벤트
    event.preventDefault(); // 동작 멈춤
    const formData = new FormData(event.target); // FormData 키워드
    console.log(formData);
    const jsonData = Object.fromEntries(formData.entries()); // 
    // formData에 입력한 값을 자바스크립트 객체로 만듦 -> formData.entries을 json으로 바꾸기
    console.log(jsonData);
    sendRequest(jsonData);
});

document.getElementById('readButton').addEventListener('click', function() { // 클릭시
    const jsonData = { action: 'read' }; // { action: 'read' } 객체
    sendRequest(jsonData, displayReadResult); // send jsonData, displayReadResult 콜백함수
});

document.getElementById('updateForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const formData = new FormData(event.target);
    const jsonData = Object.fromEntries(formData.entries());
    sendRequest(jsonData);
});

document.getElementById('deleteForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const formData = new FormData(event.target);
    const jsonData = Object.fromEntries(formData.entries());
    sendRequest(jsonData);
});

function sendRequest(jsonData, callback) { // 비동기 방식
    fetch('empJsonserver3.jsp', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json; charset=utf-8' // charset=utf-8' <= json 한글 깨짐 방지
        },
        body: JSON.stringify(jsonData) // json = 문자열
    })
    .then(response => response.json())
    .then(data => {
        if (callback) {
            callback(data);
        } else {
            alert(JSON.stringify(data));
        }
    })
    .catch(error => console.error('Error:', error));
}

function displayReadResult(data) {
    const readResultDiv = document.getElementById('readResult');
    readResultDiv.innerHTML = JSON.stringify(data, null, 2);
}