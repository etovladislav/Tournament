/**
 * Created by etovladislav on 13.03.16.
 */

'use strict';

angular
    .module('app')
    .factory('TournamentService', TournamentService);

TournamentService.$inject = ['$http'];
function TournamentService($http) {
    var service = {};

    service.GetTournaments = GetTournaments;
    service.GetMyTournaments = GetMyTournaments;
    service.GetTournamentById = GetTournamentById;
    service.Create = Create;
    service.Update = Update;

    return service;


    function GetMyTournaments() {
        return $http.get('/api/tournaments/getMyTournaments' + username);
    }

    function GetTournaments() {
        return $http.get('/api/tournaments/getTournaments');
    }

    function GetTournamentById(id) {
        return $http.get('/api/tournaments/getTournamentById/'+id);
    }
    function Create(tournament) {
        return $http.post('/api/tournaments/createTournament', tournament);
    }

    function addTeam(name, tournamentId) {
        return $http.get('/api/tournaments/addTeam?name='+ name+'&tournamentId='+tournamentId);
    }

    function Update(tournament) {
        return $http.put('/api/tournaments/update' + tournament);
    }
}