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
    var userId;

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
        loadProfile();
    }
    
    function logout() {
        userService.logout();
        window.location.replace("../login/login.template.client.html");
    }
    function loadProfile() {
        userService.loadProfile().then(renderUser);
    }

    function updateUser() {
        var user = {
            phone: $phoneNum.val(),
            email: $email.val(),
            dateOfBirth: $dateOfBirth.val()
        };
        userService.updateUser(userID, user);
    }

    function renderUser(user) {
        $staticUsername.val(user.username);
        $firstName.val(user.firstName);
        $lastName.val(user.lastName);
        $phoneNum.val(user.phone);
        $email.val(user.email);
        $staticRole.val(user.role);
        $dateOfBirth.val(user.dateOfBirth);
        userID = user.id;
    }
})();