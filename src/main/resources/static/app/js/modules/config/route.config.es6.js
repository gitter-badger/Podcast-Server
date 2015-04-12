angular
    .module('ps.config.route', ['ngRoute','cfp.hotkeys'])
    .constant('commonKey', [
        ['h', 'Goto Home', (event) => {
            event.preventDefault();
            window.location.href = '#/items';
        }],
        ['s', 'Goto Search', (event) =>  {
            event.preventDefault();
            window.location.href = '#/item/search';
        }],
        ['p', 'Goto Podcast List', (event) =>  {
            event.preventDefault();
            window.location.href = '#/podcasts';
        }],
        ['d', 'Goto Download List', (event) =>  {
            event.preventDefault();
            window.location.href = '#/download';
        }]
    ])
    .config(($routeProvider) => $routeProvider.otherwise({redirectTo: '/items'}));