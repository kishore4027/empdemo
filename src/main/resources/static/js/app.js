/**
 * 
 */
 
 
 
 //default load
 $(document).ready(function(){
	$('#emp-cre,#emp-get,#emp-search').hide();
	
	//bind Get function form
	$( "#get" ).on( "click", function() {
  		 $('#emp-cre,#emp-get,#emp-search,#btn-delete').hide();
  		 $('#emp-get,#btn-info').show();
  		 });
  	//bind create function form
	$( "#create" ).on( "click", function() {
  		 $('#emp-cre,#emp-get,#emp-search,#emp-id,#emp-upd-sub').hide();
  		 $('#emp-cre,#emp-cre-sub').show();
  		 bindDepartmentOptions();
  		 });
  	//bind update function form
	$( "#put" ).on( "click", function() {
  		 $('#emp-cre,#emp-get,#emp-search,#emp-id,#emp-cre-sub').hide();
  		 $('#emp-cre,#emp-id,#emp-upd-sub').show();
  		 bindDepartmentOptions();
  		 });
  	//bind delete function form
	$( "#delete" ).on( "click", function() {
  		 $('#emp-cre,#emp-get#emp-search,#btn-info,#emp-id').hide();
  		 $('#emp-get,#btn-delete').show();
  		 });
  	$( "#fetchAll" ).on( "click", function() {
  		 $('#emp-cre,#emp-get,#emp-search').hide();
  		 callfetchAll();
  	});
  	$( "#deleteAll" ).on( "click", function() {
  		 $('#emp-cre,#emp-get,#emp-search').hide();
  		 commonAjaxRequest('/api/employees/','DELETE',null,handleDeleteAll);
  	});	 
  	//bind search function form	
  	$( "#search" ).on( "click", function() {
  		 $('#emp-cre,#emp-get,#emp-search').hide();
  		 $('#emp-search').show();
  		 });
});
  function callfetchAll(){
		 commonAjaxRequest('/api/employees/','GET',null,handleSearch);  	
  }
  function handleDeleteAll(data,status){
	console.log("ststus:"+status+ " Data:"+data);
	alert("DeleteAll completed successfully");
	callfetchAll();
  }
  function onGetSubmit(){	
	var id=$('#emp-get-id').val().trim();
	commonAjaxRequest('/api/employees/'+id,'GET',null,getSuccessHandle);		
  }
  function getSuccessHandle(data,status){
	/*
	*<tr>
                    <th>#</th>
                    <th>EmployeeNo</th>
                    <th>Name</th>
                    <th>DateOfJoining</th>
                    <th>DepartMent</th>
                    <th>Salary</th>                    
                </tr>
                isObject(input) && isObjectEmpty(input)) ||
            (isArray(input) && input.length === 0)
	*/	
	$('#emp-tab .table tbody').empty();
	if(data instanceof Object){	
	$('#emp-tab .table tbody').append('<tr><th>'+data.id+'</th><th>'+data.no+'</th><th>'+data.name+'</th><th>'+data.dateOfJoin+'</th><th>'+data.department.description+'</th><th>'+data.salary+'</th></tr>');
 	}
  }
  function onCreateSubmit(){
	var data={};
	data["no"]=$('#no').val();
	data["name"]=$('#name').val();
	data["dateOfJoin"]=moment($('#dateOfJoin').val()).format('DD/MM/YYYY');
	data["depCode"]=$('#depCode').val();
	data["salary"]=$('#salary').val();
	commonAjaxRequest('/api/employees','POST',data,createSuccessHandle);		
  }
  
  
  function createSuccessHandle(data,status){
	/*
	*<tr>
                    <th>#</th>
                    <th>EmployeeNo</th>
                    <th>Name</th>
                    <th>DateOfJoining</th>
                    <th>DepartMent</th>
                    <th>Salary</th>                    
                </tr>
	*/	
	if(data instanceof Object){		
	$('#emp-tab .table tbody').append('<tr><th>'+data.id+'</th><th>'+data.no+'</th><th>'+data.name+'</th><th>'+data.dateOfJoin+'</th><th>'+data.department.description+'</th><th>'+data.salary+'</th></tr>');
 	}
 }
  function onUpdateSubmit(){
	let data={};
	//emp-id
	data["no"]=$('#no').val();
	data["name"]=$('#name').val();
	data["dateOfJoin"]=moment($('#dateOfJoin').val()).format('DD/MM/YYYY');
	data["depCode"]=$('#depCode').val();
	data["salary"]=$('#salary').val();
	let id=$('#emp-id').val().trim();
	commonAjaxRequest('/api/employees/'+id,'PUT',data,updateHandle);	
  }
  function updateHandle(data,status){
	$('#emp-tab .table tbody').empty();
	if(data instanceof Object){	
	$('#emp-tab .table tbody').append('<tr><th>'+data.id+'</th><th>'+data.no+'</th><th>'+data.name+'</th><th>'+data.dateOfJoin+'</th><th>'+data.department.description+'</th><th>'+data.salary+'</th></tr>');
  	}
  }
  
  function onDeleteSubmit(){
	let id=$('#emp-get-id').val();
	commonAjaxRequest('/api/employees/'+id,'DELETE',null,delHandler);	
  }
  function delHandler(data,status){
	console.log("ststus:"+status+ " Data:"+data);
	alert("Delete completed successfully");
}
  function onSearchSubmit(){
	let data={};
		data["empNo"]=$('#emp-search-no').val();
		data["name"]=$('#emp-search-name').val();
	let url='/api/employees/search?empNo='+data.empNo+'&name='+data.name;
	commonAjaxReqWithoutpayload(url,'GET',handleSearch);
  }
  function handleSearch(dataList,status){
	$('#emp-tab .table tbody').empty();
	$.each( dataList, function( i, data ) {		
	$('#emp-tab .table tbody').append('<tr><th>'+data.id+'</th><th>'+data.no+'</th><th>'+data.name+'</th><th>'+data.dateOfJoin+'</th><th>'+data.department.description+'</th><th>'+data.salary+'</th></tr>');
    })
   }
  function bindDepartmentOptions(){
	/*$.ajax('/api/departments', {
    type: 'GET',  // http method
    success: function (data, status, xhr) {
	    $('#depCode').empty();
        $.each( data, function( index, value ){
    	$('#depCode').append(`<option value="${value.code}">${value.description}</option>`);
		});
    },
    error: function (jqXhr, textStatus, errorMessage) {
           $.notify('Error' + errorMessage);
    }
	});*/
	commonAjaxRequest('/api/departments','GET',null,handleOptionData);
	
  }
  function handleOptionData(data,status){
	$('#depCode').empty();
        $.each( data, function( index, value ){
    	$('#depCode').append(`<option value="${value.code}">${value.description}</option>`);
		});
  }
  
  function commonAjaxRequest(url,method,inputData,callBack){
	$.ajax(url, {
    type: method,  // http method    
    data:JSON.stringify(inputData),
    contentType: "application/json; charset=utf-8",
	dataType: "json",
    success: function (data, status, xhr) {
	     if (typeof  callBack=== "function"){
			callBack(data,status);
		  }	    
    },
    error: function (jqXhr, status, errorMessage) {          
			console.log("status:"+status+" Uncaught Error.\n" + jqXhr.responseText);
			let error_msg = '';
			
				error_msg = 'Uncaught Error.\n' + jqXhr.responseText;
			
			// error alert message
			alert('error :: ' + error_msg);
		},

	
	});
	}
	function commonAjaxReqWithoutpayload(url,method,callBack){
	$.ajax(url, {
    type: method,  // http method    
    contentType: "application/json; charset=utf-8",
	dataType: "json",
    success: function (data, status, xhr) {
	     if (typeof  callBack=== "function"){
			callBack(data,status);
		  }	    
    },
    error: function (jqXhr, status, errorMessage) {          
			console.log("status:"+status+" Uncaught Error.\n" + jqXhr.responseText);
			let error_msg = '';
			
				error_msg = 'Uncaught Error.\n' + jqXhr.responseText;
			
			// error alert message
			alert('error :: ' + error_msg);
		},

	
	});
	}
