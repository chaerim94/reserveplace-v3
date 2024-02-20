<template>
    <v-card outlined>
        <v-card-title>
            ReservationInform
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
                    @click="reservationInform"
            >
                ReservationInform
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
        name: 'ReservationInformCommand',
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
            reservationInform() {
                this.$emit('reservationInform', this.value);
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

