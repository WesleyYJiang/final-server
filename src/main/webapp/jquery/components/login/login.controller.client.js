(function () {
    $(init);
    var $usernameFld, $passwordFld, $loginBtn;
    var userService = new UserServiceClient();

    function init() {
        $usernameFld = $("#usernameFld").val();
        $passwordFld = $("#passwordFld").val();
        $loginBtn = $("#loginBtn").click(login);
    }

    function login(){

        if ($passwordFld.val() === $verifyPasswordFld.val()){
            var user = {
                username: $usernameFld.val(),
                password: $passwordFld.val(),
                firstName: $firstNameFld.val(),
                lastName: $lastNameFld.val(),
                role: "Student"
            };
            userService.register(user);
        }
        else {
            alert('Passwords do not match!')
        }
    }
})();