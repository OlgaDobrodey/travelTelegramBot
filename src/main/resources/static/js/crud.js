function deleteCity(id) {
       jQuery(function ($) {
           $.ajax({
               url: "/bot/cities/"+id,
               type : 'DELETE',
               contentType : 'application/json; charset=utf-8',
               cache: false,
               success : function(result) {
                   window.location.href = "/bot/cities"
                   alert('Success delete');
                                 },
               error: function(xhr, resp, text) {
                    alert('delete');
               }
           });
           return false;
       });
   }

   function updateCity(id) {
          jQuery(function ($) {
               var town = JSON.stringify({
                           name: $("#name").val(),
                           information: $("#information").val(),
                                                            });
              $.ajax({
                  url: "/bot/cities/"+id,
                  type : 'PUT',
                  contentType : 'application/json; charset=utf-8',
                  cache: false,
                  data: town,
                  success : function(result) {
                      window.location.href = "/bot/cities"
                      alert('Success update');
                                    },
                  error: function(xhr, resp, text) {
                       alert('update');
                  }
              });
              return false;
          });
      }