//IIFE
(function(){
	jQuery(main);
	
    var tbody;
    var template;
    var userService = new UserServiceClient()
    var editingID = -1;
    var editing = false;
    var editTemplate;
    var editTemplateOG;
	
    function main() {
		tbody = $('tbody');
        template = $('.wbdv-template');
        editTemplate = $('.wbdv-form');
        $('#wbdv-create').click(createUser);
        $('#wbdv-update').click(editUser);
        $('#wbdv-save').click(updateUser);
		findAllUsers();
	}
    
    function findAllUsers() {
        userService.findAllUsers().then(renderUsers);
    }
	
    function renderUsers(users) {
    	tbody.empty();
        for(var i = 0; i < users.length; i++) {
            var user = users[i];
            var clone = template.clone();
            clone.attr('id', user.id);
            clone.find('.wbdv-remove').click(deleteUser);
            clone.find('.wbdv-edit').click(editUser);

            clone.find('.wbdv-username').html(user.username);
            clone.find('.wbdv-first-name').html(user.firstName);
            clone.find('.wbdv-last-name').html(user.lastName);
            clone.find('.wbdv-role').html(user.role);
            tbody.append(clone);
        }
        editTemplate.find('#usernameFld').val("");
        editTemplate.find('#firstNameFld').val("");
        editTemplate.find('#lastNameFld').val("");
        editTemplate.find('#passwordFld').val("");
    }
    
    function createUser() {
        userService.createUser(makeUserHelper()).then(findAllUsers);
    }
    
    function makeUserHelper() {
        var username = $('#usernameFld').val();
        var password = $('#passwordFld').val();
        var firstName = $('#firstNameFld').val();
        var lastName = $('#lastNameFld').val();
        var role = $('#roleFld').val();

        return {
            username: username,
            password: password,
            firstName: firstName,
            lastName: lastName,
            role: role
        };
    }
    
    function deleteUser(event) {
        var deleteBtn = $(event.currentTarget);
        var userId = deleteBtn.parent().parent().parent().attr('id');
        userService.deleteUser(userId).then(findAllUsers);
    }

    function updateUser() {
        if (!editing) {
            alert("please pick a user to edit!")
        }
        else {
            editTemplate.find('#usernameFld').attr("placeholder", "Username");
            editTemplate.find('#passwordFld').attr("placeholder", "Password");
            editTemplate.find('#firstNameFld').attr("placeholder", "First Name");
            editTemplate.find('#lastNameFld').attr("placeholder", "Last Name");

            userService.updateUser(editingID, makeUserHelper()).then(findAllUsers);
            editing = false;
        }
    }

    function editUser(event) {
        var editBtn = $(event.currentTarget);
        var userRow = editBtn.parent().parent().parent();
        editingID = userRow.attr('id');
        editing = true;
        //
        editTemplate.find('#usernameFld').attr("placeholder", userRow.find('.wbdv-username').text());
        editTemplate.find('#firstNameFld').attr("placeholder", userRow.find('.wbdv-first-name').text());
        editTemplate.find('#passwordFld').attr("placeholder", "Cannot change!");
        editTemplate.find('#lastNameFld').attr("placeholder", userRow.find('.wbdv-last-name').text());
        editTemplate.find('#roleFld').attr("placeholder", userRow.find('.wbdv-role').text());
    }
})(); 