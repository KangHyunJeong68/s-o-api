
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

    $('#appFrm')
        .on('click', "#btn_app_insert" , function() {
            var $appName = $('#app_name');
            if ($appName.val() == '') {
                alert('앱 이름을 입력하세요.')
                $appName.focus();
                return;
            }
            $('#appFrm').submit();
        })

    $('#appList')
        .on('click', '[name="btn_deleteApp"]', function(e) {
            var $target = $(e.currentTarget);
            var idx = $target.closest('td').data('idx');

            if (idx === undefined) {
                alert("삭제 실패");
                return;
            }

            $.ajax({
                url : "/application/delete-app",
                type : "POST",
                data : {
                    idx : idx
                }
            }).success(function(res) {
                if (res > 0) {
                    location.reload();
                } else {
                    alert("삭제싪애애ㅐ애애")
                }
            })
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