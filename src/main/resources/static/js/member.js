
jQuery(function ($) {
    console.log(1111);
    // 회원가입
    $('#joinFrm')
        .on('keyup', '#user_name', function() {

        })
        .on('click', '#btn_join', function() {
            var $password = $('#password'),
                $password2 = $('#password2')
            ;

            if ($password.val() !== $password2.val()) {
                alert('입력하신 비밀번호가 다릅니다.');
                return false;
            }
        })
    ;


    // 로그인
    $('#loginFrm')
        .on('click', '#btn_join', function() {
            location.href = "/developer/join";
        })
        .on('click', '#btn_login', function() {

        })
    ;



});

var member = {
  'chkSubmit' : function() {
      var $name = $('#user_name'),
          $email = $('#email'),
          $company_nm = $('#company_name')
          // $email = $('#email'),
  }


};