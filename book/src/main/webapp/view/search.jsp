<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form action="" method = "post">
			<div class="form-group col-6">
				<select name="criteria" id="" class = "form-control">
					<option value="code">code</option>
					<option value="price">price</option>		
				</select>
			</div>
			<div class="form-group col-6" >
				<input type="text" class="form-control" id="keyword" placeholder = "keyword" required="required" name = "keyword">
			</div>
			<button type="submit" class="btn btn-primary" style="margin-left: 16px">search</button>
</form>