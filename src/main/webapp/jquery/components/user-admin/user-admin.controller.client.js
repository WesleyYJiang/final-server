//IIFE
(funciton() {
	jQuery(main);
	fuction main() {
		var tr =$('.template');
		
		var users = [{username: 'bob'}, {username: 'charlie'}]
		
		var tbody = $('tbody');
		
		
		for(var i = 0; i < users.length: i++){
			var user = users[i];
			var clone = tr.clone();
			clone.find('.username').html(user.username);
			tbody.append(clone);
		}
	}
})();