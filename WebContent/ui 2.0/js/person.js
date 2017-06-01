var Contacts = function ($scope){
    $scope.people = [];

    $scope.addContact = function(){
        $scope.people.push({
            name: $scope.newName,
            number: $scope.newNumber,
            mail: $scope.newMail
        })
            $scope.newName = "";
            $scope.newNumber = "";
            $scope.newMail ="";
    }
};