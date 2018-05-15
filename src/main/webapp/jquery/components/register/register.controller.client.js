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

        findUserById(12);
    }

    function createUser() {
        if($passwordFld != $verifyPasswordFld) {
            alert('Passwords do not match!')
        }
        else {
            var user = {
                username: $usernameFld.val(),
                firstName: $firstNameFld.val(),
                lastName: $lastNameFld.val(),
                password: $passwordFld.val()
            };

            userService.createUser(user).then(success());
        }
    }

    function success(response) {
        if(response === null) {
            alert('username is taken!')
        } else {
            alert('Your account is created!');
        }
    }

    function findUserById(userId) {
        userService
            .findUserById(userId)
            .then(renderUser);
    }

    function renderUser(user) {
        console.log(user);
        $staticEmail.val(user.username);
        $firstName.val(user.firstName);
        $lastName.val(user.lasteName);
    }
})();