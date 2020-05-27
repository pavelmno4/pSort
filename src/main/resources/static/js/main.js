var participantApi = Vue.resource('/test');

Vue.component('participant-row', {
    props: ['participant'],
    template: '<div><i>({{ participant.id }})</i> {{ participant.lastName }}</div>'
});

Vue.component('participants-list', {
  props: ['participants'],
  template:
  '<div>' +
      '<participant-row v-for="participant in participants" :key="participant.id" :participant="participant " />'  +
  '</div>',
  created: function() {
    participantApi.get().then(result =>
        result.json().then(data =>
            data.forEach(participant => this.participants.push(participant))
        )
     )
   }
});

var app = new Vue({
  el: '#app',
  template: '<participants-list :participants="participants" />',
  data: {
    participants: []
  }
});