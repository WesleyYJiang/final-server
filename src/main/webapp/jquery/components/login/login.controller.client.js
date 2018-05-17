(function () {
    $(init);

    var $usernameFld, $passwordFld;
    var $loginBtn;
    var userService = new UserServiceClient();

    function init() {
        $usernameFld = $("#usernameFld");
        $passwordFld = $("#passwordFld");
        $loginBtn = $("#loginBtn").click(login);
    }

    function login(){
        userService.login($usernameFld.val(), $passwordFld.val());
    }
})();