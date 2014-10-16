
<g:set var="formaction" value="${contact?"updatecontact":"savenewcontact"}" />
<g:form name="editContactForm" action="${formaction}" class="form-horizontal" role="form">
    <input type="hidden" name="id" value="${contact?.id}"/>
    <div class="form-group">
        <label for="firstname">First Name</label>
        <input type="text" name="firstName" id="firstname" value="${contact?.firstName}" class="form-control" />
    </div>
    <div class="form-group">
        <label for="lastname">Last Name</label>
        <input type="text" name="lastName" id="lastname" value="${contact?.lastName}" class="form-control" />
    </div>
    <div class="form-group">
        <label for="phonenumber">Phone Number</label>
        <input type="text" name="phoneNumber" id="phonenumber" value="${contact?.phoneNumber}" class="form-control" />
    </div>
    <div class="right">
        <button type="submit" class="btn btn-default">Submit</button>
    </div>
</g:form>