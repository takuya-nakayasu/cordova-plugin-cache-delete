var exec = require("cordova/exec");

var CashDelete = function (success, error) {
  exec(success, error, "CashDelete", "task", []);
};

module.exports = CashDelete;
