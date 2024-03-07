var spreadSheet=SpreadsheetApp.openByUrl("https://docs.google.com/spreadsheets/d/1eliTDBZ7MxyQjzkOk42WFEtBol9Fqb0SqBthJZp4nf8/edit#gid=0");
var sheet=spreadSheet.getSheetByName("Sheet1");

function doGet(e) {
  Logger.log(JSON.stringify(e));
  var action = e.parameter.action;
  if(action == "create") {
    return createData(e);
  }
}

function createData(e) {
  var id=sheet.getLastRow();
  var name=e.parameter.name;
  var surname=e.parameter.surname;
  var age=e.parameter.age;
  sheet.appendRow([id,name,surname,age])

  return ContentService.createTextOutput("Created").setMimeType(ContentService.MimeType.TEXT);
}
