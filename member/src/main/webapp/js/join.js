/**
 * joinForm.jsp 회원가입 유효성 검증 
 */

$(function(){
	 $("#joinform").validate({
    // 검증 규칙 명시 -rules에 추가
    // 규칙을 적용할 요소는 이름을 사용
    rules: {
      userid: {
        required: true,
        validId: true,
      },
      password: {
        required: true,
		validPwd:true
      },
      confirm_password: {
        required: true,
        validPwd:true,
        equalTo: "#password",
      },
      name: {
        required: true,
      },
	  gender:{
		required:true,
	},
      email: {
        required: true,
		email:true
      }     
    },
    // 검증규칙과 맞지 않는 경우 보여줄 메세지 작성
    messages: {
      userid: {
        required: "아이디는 필수요소입니다.",
      },
      password: {
        required: "비밀번호를 필수 입력 요소입니다",
      },
      confirm_password: {
        required: "비밀번호를 필수 입력 요소입니다",
        equalTo: "비밀번호가 서로 다릅니다.",
      },
      name: { 
        required: "이름은 필수요소입니다.",
      },
      email: {
        required: "이메일은 필수요소입니다.",
        email: "이메일 주소를 확인해주세요^^.",
      }
    },
	// error message location 
	errorPlacement:function(error,element){
		$(element).closest("form").find("small[id='"+element.attr("id")+"']").append(error);
	}
  })

});
// 사용자 지정 규칙명시
$.validator.addMethod("validId", function (value) {
    let regId = /^(?=.*[A-Za-z])(?=.*[\d])[A-Za-z\d]{6,12}$/;
    return regId.test(value); // true or false
  },"아이디는 영대소문자, 숫자의 조합으로 6~12자리로 만들어야 합니다.")

$.validator.addMethod("validPwd", function (value) {
    let regPwd = /^(?=.*[A-Za-z])(?=.*[\d])(?=.*[!@$*])[A-Za-z\d!@$*]{8,15}$/;
    return regPwd.test(value); // true or false
  }, "비밀번호는 영대소문자, 숫자, 특수문자 8~15 자리여 이사람아 .")




