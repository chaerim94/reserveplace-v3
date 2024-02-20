<template>

    <v-data-table
        :headers="headers"
        :items="manageStatus"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'ManageStatusView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            manageStatus : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/manageStatuses'))

            temp.data._embedded.manageStatuses.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.manageStatus = temp.data._embedded.manageStatuses;
        },
        methods: {
        }
    }
</script>

