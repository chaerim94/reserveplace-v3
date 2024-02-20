<template>
    <v-card outlined>
        <v-card-title>
            ReservationCancelProcessing
        </v-card-title>

        <v-card-text>
            <Number label="Stock" v-model="value.stock" :editMode="editMode"/>
            <Number label="OrderId" v-model="value.orderId" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="reservationCancelProcessing"
            >
                ReservationCancelProcessing
            </v-btn>
            
            <v-btn
                    color="primary"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'ReservationCancelProcessingCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.stock = 0;
            this.value.orderId = 0;
        },
        watch: {
        },
        methods: {
            reservationCancelProcessing() {
                this.$emit('reservationCancelProcessing', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

