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
        userService.login($usernameFld, $passwordFld);
    }
})();