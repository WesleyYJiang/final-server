(function() {
    $(init);

    var $staticUsername;
    var $firstName;
    var $lastName;
    var $phoneNum;
    var $email;
    var $staticRole;
    var $dateOfBirth;
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
        if($dateOfBirth.val() === "") {
            alert("Please enter your date of birth!");
        }
        else {
            var user = {
                phone: $phoneNum.val(),
                email: $email.val(),
                dateOfBirth: $dateOfBirth.val()
            };
            userService.updateUser(userId, user);
        }
    }

    function renderUser(user) {
        userService.findByUsername(user.username).then(getUserInfo);
    }

    function getUserInfo(user){
        console.log(user);
        userId = user['0']['id'];
        $staticUsername.val( user['0']['username']);
        $firstName.val(user['0']['firstName']);
        $lastName.val(user['0']['lastName']);
        $phoneNum.val(user['0']['phone']);
        $email.val(user['0']['email']);
        $staticRole.val(user['0']['role']);
        $dateOfBirth.val(user['0']['dateOfBirth']);
    }
})();