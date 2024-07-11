function doLike(uid,pid)
{
	const d={
		
		uid:uid,
		pid:pid,
		operation:'like'
		
	}
	$.ajax({
		url:"LikeServlet",
		method:"POST",
		data:d,
		success:function(data,textStatus,jqXHR){
			console.log("Success",data)
			if(data.trim()=='true')
			{
				let c=$(".like-counter").html();
				c++;
				$('.like-counter').html(c);
			}
			else if (data.trim() == 'already liked') {
                alert('You have already liked this post.');
            }
		},
		error:function(jqXHR,textStatus,errorThrown){
			console.log("Error",data)
		}
		
		
	});
}