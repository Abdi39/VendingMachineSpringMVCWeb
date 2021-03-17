<%-- 
    Document   : vendingMachine
    Created on : Nov 9, 2020, 5:42:02 PM
    Author     : Dreamville
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vending Machine</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">        
        <link href="${pageContext.request.contextPath}/css/vendingMachine.css" rel="stylesheet">  
    </head>
    <body>
        
    <div class="container">
        <h1 class="text-center">Vending Machine</h1>
        <hr/>
            <ul class="list-group" id="errorMessages"></ul>
          
            <div class="row"> 
                
            <div class="col-md-8" >
              <div  class="row" id="itemsDisplay">
                
                
                <form method="GET" action="selectItem">
                   <c:forEach var="currentItem" items="${vendingItems}">
                      <div class="col-md-4">
                          <button name ="chosenItem" type="submit"  class="btn btn-default" value="${currentItem.itemID}" id="itemsDisplay" >
                                    <p class="item-number text-left"><c:out value="${currentItem.itemID}"/></p>
                                    <br/>
                                    <p class="text-center"><c:out value="${currentItem.itemName}"/></p>
                                    <br/>
                                    <p class="text-center"><c:out value="$${currentItem.itemPrice}"/></p>
                                    <br/>
                                    <p class="text-center"><c:out value="Quantity: ${currentItem.itemQuantity}"/></p>
                          </button>
                    </div>
                            
                   </c:forEach>
                 </form> 
             </div>

             </div>
            
            
         <div class="col-md-4">
              <div class="row">
                    <h3>Total $ In </h3>
                    
                   <div class="row">

        	         <div class="panel panel-default">
        		       <input type="text" value="${showMoney}" placeholder="0.00" readonly class="form-control"/>
        		  </div>
                   </div>
                  
                        
                     <form method="GET" action="addMoney">
                          <div class="row">
                              
                            <button type="submit" id="add-dollar-button" formaction= "addDollar" class="btn btn-success col-md-4">Add Dollar</button>
                                    <div class="col-md-1"></div>
                            <button type="submit" id="add-quarter-button" formaction="addQuarter" class="btn btn-success col-md-4">Add Quarter</button>
                          </div>
                                <br>
                           <div class="row">
                             <button type="submit" id="add-dime-button" formaction="addDime" class="btn btn-success col-md-4">Add Dime</button>
                        
                                       <div class="col-md-1"></div>
                        
                             <button type="submit" id="add-nickel-button" formaction="addNickel" class="btn btn-success col-md-4">Add Nickel</button>
                           </div>
                                
                              <hr/>
                    </form>  
                         
                          
                            
                            
                 <div class="row">
                    <h3>Messages</h3>
                       
                     <form action="purchaseItem" method="GET">
                         <div class="row">
                             <div class="panel panel-default">
                                 <input type="text" value="${displayMessage}" name= "viewMessage" readonly class="form-control"/>
                             </div>
                         </div>
                          
                     
            
                  <h3>Item:</h3>
                       <div class="row">
                             <div class="panel panel-default">
                                 <input type="submit" value="${displayItemId}" name= "itemName"readonly class="form-control"/>
                             </div>
                       </div>
                
                        
                        <button type="submit" class="btn btn-success col-md-4" id="make-purchase-button">Make Purchase</button>
                    
                 </div>
                             
                    </form>
                              <hr/>
                              
                   <div class="row">
                        <h3>Change</h3>
                      <form action="returnChange" method="GET">
                           <div class="panel panel-default">
                                 <input type="submit" value="${displayChange}" name= "returnChange" readonly class="form-control"/>
                           </div>
                    
                            <button type="button" class="btn btn-success col-md-4" id="change-due-back-button">Change</button>
                      </form>
                   </div> 
             </div>                           
        </div>
     </div>
    </div>
               <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
               <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>
