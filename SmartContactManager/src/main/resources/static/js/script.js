console.log("this is testing")

const toggleSidebar = () =>{

	if($(".sidebar").is(":visible")){

        $(".sidebar").css("display","none");
        $(".content").css("margin-left","0%");
    }
    else{

        $(".sidebar").css("display","block");
        $(".content").css("margin-left","20%");

    }

};

	
	
	const search =() => {
	    

	    var query = $("#search-input").val();

	    if(query == ""){
	        $(".search-result").hide();
	    }
	    else{

	        console.log(query);

	        //sending request to server

	        var url = `http://localhost:8080/search/${query}`;
		console.log(url);
	        fetch(url).then(function (response){
	            return response.json();                    
	        }).then(function (data){
				
				let text = `<div class='list-group'>`;
				
				data.forEach((contact) => {
				text += `<a href='/user/${contact.cid}/contact' class='list-group-item list-group-item-action'>${contact.name}</a>`;
				});
				
	            text += `</div>`;
	            $(".search-result").html(text);
	             $(".search-result").show();
	        });


	        
	    }


	};