var states = new Bloodhound({
	datumTokenizer: Bloodhound.tokenizers.whitespace,
	queryTokenizer: Bloodhound.tokenizers.whitespace,
	// `states` is an array of state names defined in "The Basics"
	remote: {
		url: 'http://localhost:9200/autocomplete/_search?q=key:%QUERY',
		wildcard: '%QUERY',
		filter: function (data) {
			// Map the remote source JSON array to a JavaScript object array
			return data.hits.hits.map(i => i._source.key)
		}
	}
});

$('#keyword').typeahead({
		hint: true,
		highlight: true,
		minLength: 1
	},
	{
		name: 'states',
		source: states
	});
