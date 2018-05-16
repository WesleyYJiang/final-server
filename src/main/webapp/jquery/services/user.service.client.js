function UserServiceClient() {
    this.createUser = createUser;
    this.findAllUsers = findAllUsers;
    this.deleteUser = deleteUser;
    this.findUserById = findUserById;
    this.updateUser = updateUser;
    this.register = register;
    //this.login = login();
    this.url = '/api/';
    var self = this;

    function findUserById(userId) {
        return fetch(self.url + 'user/' + userId)
            .then(function (response) {
                return response.json();
            });
    }

    // function login(username, password) {
    //     return fetch('/api/login', {
    //         method: 'post',
    //         body: JSON.stringify({username:username, password: password}),
    //         headers: {
    //             'content-type': 'application/json'
    //         }
    //     }).then(function (response) {
    //         return response.json();
    //     });
    // }

    function findAllUsers() {
        return fetch(self.url + 'user/').then(function (response) {
            return response.json();
        });
    }

    function createUser(user) {
        return fetch(self.url + 'user/', {
            method: 'post',
            body: JSON.stringify(user),
            headers: {'content-type': 'application/json'}
        });
    }

    function register(user) {
        return fetch('/api/register' , {
            method: 'post',
            body: JSON.stringify(user),
            headers: {'content-type': 'application/json'}
        }).then(function(response) {
            if (response.ok) {
                return response.json();
            }
            throw new Error('Network response was not ok.');
        }).catch(function(error) {
            alert('username is taken!');
        });
    }


    function deleteUser(userId) {
        return fetch(self.url + 'user/' + userId, {
            method: 'delete'
        })
    }

    function updateUser(userId, user) {
        return fetch(self.url + 'user/' + userId, {
            method: 'put',
            body: JSON.stringify(user),
            headers: {'content-type': 'application/json'}
        }).then(function(response) {
            if (response.ok) {
                alert("Update Completed!")
                return response.json();
            }
            throw new Error('Network response was not ok.');
        }).catch(function(error) {
            alert("can not update!")
        });
    }


}
