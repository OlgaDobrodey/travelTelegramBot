$(document).ready(function(){

         $("#button-add-cities").click(function(e) {
             $("#cities-form").show();

             e.preventDefault();
         });

         $("#button-new-cities").click(function(e) {

             var town = JSON.stringify({
                              name: $("#city-name").val(),
                              information: $("#city-information").val(),
                                                         });
             $.ajax({
                   url: '/bot/cities',
                   type: 'POST',
                   contentType: 'application/json',
                   cache: false,
                   data: town,
                   success: function(town, textStatus, jqXHR) {
                       if(jqXHR.status==201) {
                         alert('Ok! City saved!');
                         window.location.reload();
                       }
                   },
                   error: function (responseData) {
//                                  window.location.href = "${pageContext.request.contextPath}/address";
                                  alert('Error save');
                              }
               });

         });
             $("#button-update-city").click(function(e) {
                      $("#cities-form-update").show();

                      e.preventDefault();
                  });

 });