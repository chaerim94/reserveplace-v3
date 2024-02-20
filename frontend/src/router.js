
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import PlaceAccommodationManager from "./components/listers/PlaceAccommodationCards"
import PlaceAccommodationDetail from "./components/listers/PlaceAccommodationDetail"

import PaymentPaymentHistoryManager from "./components/listers/PaymentPaymentHistoryCards"
import PaymentPaymentHistoryDetail from "./components/listers/PaymentPaymentHistoryDetail"

import ManagementReservationManagementManager from "./components/listers/ManagementReservationManagementCards"
import ManagementReservationManagementDetail from "./components/listers/ManagementReservationManagementDetail"

import NotificationLogManager from "./components/listers/NotificationLogCards"
import NotificationLogDetail from "./components/listers/NotificationLogDetail"



export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/places/accommodations',
                name: 'PlaceAccommodationManager',
                component: PlaceAccommodationManager
            },
            {
                path: '/places/accommodations/:id',
                name: 'PlaceAccommodationDetail',
                component: PlaceAccommodationDetail
            },

            {
                path: '/payments/paymentHistories',
                name: 'PaymentPaymentHistoryManager',
                component: PaymentPaymentHistoryManager
            },
            {
                path: '/payments/paymentHistories/:id',
                name: 'PaymentPaymentHistoryDetail',
                component: PaymentPaymentHistoryDetail
            },

            {
                path: '/managements/reservationManagements',
                name: 'ManagementReservationManagementManager',
                component: ManagementReservationManagementManager
            },
            {
                path: '/managements/reservationManagements/:id',
                name: 'ManagementReservationManagementDetail',
                component: ManagementReservationManagementDetail
            },

            {
                path: '/notifications/logs',
                name: 'NotificationLogManager',
                component: NotificationLogManager
            },
            {
                path: '/notifications/logs/:id',
                name: 'NotificationLogDetail',
                component: NotificationLogDetail
            },




    ]
})
