(function() {
    $(init);

    var $staticUsername;
    var $firstName;
    var $lastName;
    var $phoneNum;
    var $email;
    var $staticRole;
    var $dateOfBirth
    var $updateBtn;
    var $logoutBtn;
    var userService = new UserServiceClient();

    function init() {
        $staticUsername = $("#staticUsername");
        $firstName = $("#staticFirstName");
        $lastName = $("#staticLastName");
        $phoneNum = $("#phoneNum");
        $email = $("#email");
        $staticRole = $("#staticRole");
        $dateOfBirth = $("#dateOfBirth");
        $updateBtn = $("#updateBtn").click(updateUser);
        $logoutBtn = $("#logoutBtn").click(logout);
        findUserById(102);
    }
    
    function logout() {
        window.location.replace("../login/login.template.client.html");
    }

    function updateUser() {
        var user = {
            phone: $phoneNum.val(),
            email: $email.val(),
            dateOfBirth: $dateOfBirth.val()
        };
        userService.updateUser(102, user);
    }

    function findUserById(userId) {
        userService.findUserById(userId).then(renderUser);
    }

    function renderUser(user) {
        $staticUsername.val(user.username);
        $firstName.val(user.firstName);
        $lastName.val(user.lastName);
        $phoneNum.val(user.phone);
        $email.val(user.email);
        $staticRole.val(user.role);
        $dateOfBirth.val(user.dateOfBirth);
    }
})();