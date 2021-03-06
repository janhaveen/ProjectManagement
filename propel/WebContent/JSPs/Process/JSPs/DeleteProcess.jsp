<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="modal fade" id="centralModalDangerDemo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-notify modal-danger" role="document">
        <!--Content-->
        <div class="modal-content">
            <!--Header-->
            <div class="modal-header" style="background:#cc4141;">
                <h6 class="heading" style="color: white;">Delete Process</h6>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true" class="white-text">&times;</span>
                </button>
            </div>
            <!--Body-->
            <div class="modal-body">
                <input type="hidden" id="DeleteProcessId" name="DeleteProcessId">
                <div class="row">
                    <div class="col-3">
                        <p></p>
                        <p class="text-center"><img class="warningImage" src="../../../img/deleteModel.png"></p>
                    </div>
                    <div class="col-9">
                        <br>
                        <p>Process details will be deleted from system.</p>
                       <p>Click <b>'Confirm'</b> to proceed, and <b>'Close'</b> to cancel.</p>
                    </div>
                </div>
            </div>
            <!--Footer-->
            <div class="modal-footer justify-content-center">
                <a type="button" class="btn btn-danger-modal" id="DeleteProcessConfirmed" style="background:#cc4141;color: white;">Confirm</a>
                <a type="button" class="btn btn-outline-secondary-modal waves-effect" data-dismiss="modal">Close</a>
            </div>
        </div>
        <!--/.Content-->
    </div>
</div>
</body>
</html>