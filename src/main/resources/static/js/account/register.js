const registerButton = document.querySelector(".account-button");

registerButton.onclick = () => {
  const accountInputs = document.querySelectorAll(".account-input");

  let user = {
    lastName : accountInputs[0].value,
    firstName : accountInputs[1].value,
    email : accountInputs[2].value,
    password : accountInputs[3].value,
  }

  // let ajaxOption = {
  //   async: false,                 // 필수
  //   type: "post",                 // 필수(post, get)
  //   url: "/api/account/register", // 필수
  //   data: user,                   // 전송할 데이터가 있으면
  //   dataType: "json",             // json와 text 등을 사용함 주로 json
  //   success: (response) => {      // 성공시 실행될 메소드
  //     alert("회원가입 요청 성공");
  //   },
  //   error: (error) => {           // 실패시 실행될 메소드
  //     alert("회원가입 요청 실패");
  //   }
  // }

  $.ajax({
    async: false,                   // 필수
    type: "post",                   // 필수(post, get)
    url: "/api/account/register",   // 필수
    contentType: "application/json",// 전송할 데이터가 json인 경우
    data: JSON.stringify(user),     // 전송할 데이터가 있으면
    // JSON.stringify() - js 객체를 JSON 문자열로 변환
    // JSON.parse()     - JSOn 문자열을 js 객체로 변환
    dataType: "json",               // json와 text 등을 사용함 주로 json
    success: (response, textStatus, request) => {        // 성공시 실행될 메소드
      console.log(response);
      const successURI = request.getResponseHeader("Location");
      location.replace(successURI + "?email=" + response.data); // Location 지정한 곳 + response.data까지
    },
    error: (error) => {             // 실패시 실행될 메소드
      console.log(error.responseJSON.data);
      loadErrorMessage(error.responseJSON.data);
    }
  });
}

function loadErrorMessage(errors) {
  const errorList = document.querySelector(".errors"); // 숨겨진 객체?
  const errorMsgs = document.querySelector(".error-msgs");
  const errorArray = Object.values(errors); // JSON 형태에서 keys, values, entries(둘 다) 리스트 형태로 변환
  
  errorMsgs.innerHTML = "";

  errorArray.forEach(error => {
    errorMsgs.innerHTML += `
      <li>${error}</li>
    `;
  });

  errorList.classList.remove("errors-invisible");
}