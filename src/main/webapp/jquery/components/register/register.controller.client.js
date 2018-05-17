(function () {
    $(init);
    var $usernameFld, $firstNameFld, $lastNameFld, $passwordFld, $verifyPasswordFld, $registerBtn;
    var userService = new UserServiceClient();

    function init() {
        $usernameFld = $("#usernameFld");
        $firstNameFld = $("#firstNameFld");
        $lastNameFld = $("#lastNameFld");
        $passwordFld = $("#passwordFld");
        $verifyPasswordFld = $("#verifyPasswordFld");
        $registerBtn = $("#registerBtn").click(createUser);
    }

    function createUser(){
        if ($passwordFld.val() === ''){
            alert('Password can not be empty!');
        }
        else if ($passwordFld.val() === $verifyPasswordFld.val()){
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
            alert('Passwords do not match!');
        }
    }
})();