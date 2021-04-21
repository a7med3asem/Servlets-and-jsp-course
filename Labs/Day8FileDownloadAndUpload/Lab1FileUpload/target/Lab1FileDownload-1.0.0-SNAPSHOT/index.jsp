<!DOCTYPE html>
<html>
  <head>
    <title>Download file</title>
  </head>
  <body>
    <form
      action="FileUploadServlet"
      method="POST"
      enctype="multipart/form-data"
    >
      File : <input type="file" name="file" /><br/>
      Destination:<input type="text" value="/temp" name"destination"/>
      <input type="submit" value="upload" name="upload"/>
    </form>
  </body>
</html>
