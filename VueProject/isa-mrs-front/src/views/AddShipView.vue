<template>
    <div>
        <NavbarUser></NavbarUser>
        <form @submit.prevent="addShip" class="w-50 mx-auto mt-5">
            <h2> New ship </h2>
                <div class="form-group mb-3">
                    <label>Name</label>
                    <input v-model="form.name" type="text" class="form-control" placeholder="Name is required."/>
                </div>
                <div class="form-group mb-3">
                    <label>Description</label>
                    <textarea v-model="form.description" type="text" class="form-control" placeholder="Description is required."/>
                </div>
                <div class="form-group mb-3">
                    <label>Country</label>
                    <input v-model="form.country" type="text" class="form-control" placeholder="Country is required, and it starts with first capital letter."/>
                </div>
                <div class="form-group mb-3">
                    <label>City</label>
                    <input v-model="form.city" type="text" class="form-control" placeholder="City is required, and it starts with first capital letter."/>
                </div>
                <div class="form-group mb-3">
                    <label>Address</label>
                    <input v-model="form.address" type="text" class="form-control" placeholder="Address is required."/>
                </div>
                <div class="form-group mb-3">
                    <label>Ship type</label>
                    <input v-model="form.shipType" type="text" class="form-control" placeholder="Ship type is required."/>
                </div>
                <div class="form-group mb-3">
                    <label>Ship length</label>
                    <input v-model.number="form.shipLength" type="number" class="form-control" placeholder="Ship length is required, and it must be number greater than 5."/>
                </div>
                <div class="form-group mb-3">
                    <label>Engine number</label>
                    <input v-model="form.engineNumber" type="text" class="form-control" placeholder="Engine number is required."/>
                </div>
                <div class="form-group mb-3">
                    <label>Engine power</label>
                    <input v-model.number="form.enginePower" type="number" class="form-control" placeholder="Engine power is required, and it must be number greater than 40."/>
                </div>
                <div class="form-group mb-3">
                    <label>Maximal speed</label>
                    <input v-model="form.maxSpeed" type="text" class="form-control" placeholder="Maximal speed is required, and it must be in format: number km/h."/>
                </div>
                <div class="form-group mb-3">
                    <label>Capacity</label>
                    <input v-model.number="form.capacity" type="number" class="form-control" placeholder="Capacity is required, and it must be number greater than 0."/>
                </div>
                <div class="form-group mb-3">
                    <label>Price</label>
                    <input v-model.number="form.price" type="number" class="form-control" placeholder="Price is required, and it must be number greater than 0."/>
                </div>
                <div class="form-group mb-3">
                    <label style="font-weight: bold;">Rules of conduction:</label>
                    <br>
                    <div class="form-group mb-3">
                        <input type="checkbox" v-model="form.rulesOfConduction" value="Smoking disallowed"/>
                        <label style="margin: 5px">Smoking disallowed</label>
                    </div>
                    <div class="form-group mb-3">
                        <input type="checkbox" v-model="form.rulesOfConduction" value="Pet friendly"/>
                        <label style="margin: 5px">Pet friendly</label>
                    </div>
                    <div class="form-group mb-3">
                        <input type="checkbox" v-model="form.rulesOfConduction" value="Parties disallowed"/>
                        <label style="margin: 5px">Parties disallowed</label>
                    </div>
                    <div class="form-group mb-3">
                        <input type="checkbox" v-model="form.rulesOfConduction" value="Drinking disallowed"/>
                        <label style="margin: 5px">Drinking disallowed</label>
                    </div>
                    <div class="form-group mb-3">
                        <input type="checkbox" v-model="form.rulesOfConduction" value="Weapons disallowed"/>
                        <label style="margin: 5px">Weapons disallowed</label>
                    </div>
                </div>
                <div class="form-group mb-3">
                    <label style="font-weight: bold;">Additional services:</label>
                    <br>
                    <template v-for="tag in tags">
                        <div class="form-group mb-3" :key="tag.id">
                            <input type="checkbox" v-model="form.additionalServices" :value="tag.name" :key="tag.id"/>
                            <label style="margin: 5px" :for="tag.key">{{tag.name}}</label>
                        </div>
                    </template>
                </div>
                <div class="form-group mb-3">
                    <label style="font-weight: bold;">Navigation equipment:</label>
                    <br>
                    <div class="form-group mb-3">
                        <input type="checkbox" v-model="form.navigationEquipment" value="Gyro Compass"/>
                        <label style="margin: 5px">Gyro Compass</label>
                    </div>
                    <div class="form-group mb-3">
                        <input type="checkbox" v-model="form.navigationEquipment" value="Radar"/>
                        <label style="margin: 5px">Radar</label>
                    </div>
                    <div class="form-group mb-3">
                        <input type="checkbox" v-model="form.navigationEquipment" value="Autopilot"/>
                        <label style="margin: 5px">Autopilot</label>
                    </div>
                    <div class="form-group mb-3">
                        <input type="checkbox" v-model="form.navigationEquipment" value="Echo sounder"/>
                        <label style="margin: 5px">Echo sounder</label>
                    </div>
                    <div class="form-group mb-3">
                        <input type="checkbox" v-model="form.navigationEquipment" value="Magnetic Compass"/>
                        <label style="margin: 5px">Magnetic Compass</label>
                    </div>
                    <div class="form-group mb-3">
                        <input type="checkbox" v-model="form.navigationEquipment" value="ARPA"/>
                        <label style="margin: 5px">ARPA</label>
                    </div>
                    <div class="form-group mb-3">
                        <input type="checkbox" v-model="form.navigationEquipment" value="GPS Receiver"/>
                        <label style="margin: 5px">GPS Receiver</label>
                    </div>
                    <div class="form-group mb-3">
                        <input type="checkbox" v-model="form.navigationEquipment" value="Navigation lamps"/>
                        <label style="margin: 5px">Navigation lamps</label>
                    </div>
                </div>
                <div class="form-group mb-3">
                    <label style="font-weight: bold;">Fishing equipment: </label>
                    <div class="form-group mb-3">
                        <input type="checkbox" v-model="form.fishingEquipment" value="Hooks">
                        <label style="margin: 5px">Hooks</label>
                    </div>
                    <div class="form-group mb-3">
                        <input type="checkbox" v-model="form.fishingEquipment" value="Lines">
                        <label style="margin: 5px">Lines</label>
                    </div>
                    <div class="form-group mb-3">
                        <input type="checkbox" v-model="form.fishingEquipment" value="Floats">
                        <label style="margin: 5px">Floats</label>
                    </div>
                    <div class="form-group mb-3">
                        <input type="checkbox" v-model="form.fishingEquipment" value="Rods">
                        <label style="margin: 5px">Rods</label>
                    </div>
                    <div class="form-group mb-3">
                        <input type="checkbox" v-model="form.fishingEquipment" value="Reels">
                        <label style="margin: 5px">Reels</label>
                    </div>
                    <div class="form-group mb-3">
                        <input type="checkbox" v-model="form.fishingEquipment" value="Baits">
                        <label style="margin: 5px">Baits</label>
                    </div>
                    <div class="form-group mb-3">
                        <input type="checkbox" v-model="form.fishingEquipment" value="Lures">
                        <label style="margin: 5px">Lures</label>
                    </div>
                    <div class="form-group mb-3">
                        <input type="checkbox" v-model="form.fishingEquipment" value="Spears">
                        <label style="margin: 5px">Spears</label>
                    </div>
                    <div class="form-group mb-3">
                        <input type="checkbox" v-model="form.fishingEquipment" value="Nets">
                        <label style="margin: 5px">Nets</label>
                    </div>
                    <div class="form-group mb-3">
                        <input type="checkbox" v-model="form.fishingEquipment" value="Gaffs">
                        <label style="margin: 5px">Gaffs</label>
                    </div>
                    <div class="form-group mb-3">
                        <input type="checkbox" v-model="form.fishingEquipment" value="Traps">
                        <label style="margin: 5px">Traps</label>
                    </div>
                </div>
                <div class="form-group mb-3">
                    <label>Pictures:</label>
                    <input accept="image/*" type="file" class="form-control" @change="addPicture($event)" multiple/>
                </div>
                <div class="form-group mb-3">
                    <label>Reservation cancellation conditions</label>
                    <textarea v-model="form.reservationCancellationConditions" type="text" class="form-control"/>
                    <p v-if="!cancellationIsValid" class="alert alert-danger">Reservation cancellation conditions are required.</p>
                </div>
                <div class="form-group mb-3">
                    <button type="submit" class="btn btn-primary float-end">Add ship</button>
                </div>
        </form>
        <br><br><br><br><br><br>
    </div>
</template>

<script>
    import Vue from 'vue'
    import axios from 'axios'
    import VueAxios from 'vue-axios'
    import router from '@/router'
    import NavbarUser from '@/components/NavbarUser.vue'

    Vue.use(VueAxios, axios)

    export default {
        name: "AddShip",
        components: {
            NavbarUser
        },
        data() {
            return {
                form: {
                    name: null,
                    description: null,
                    country: null,
                    city: null,
                    address: null,
                    shipType: null,
                    shipLength: null,
                    engineNumber: null,
                    enginePower: null,
                    maxSpeed: null,
                    capacity: null,
                    price: null,
                    rulesOfConduction: [],
                    navigationEquipment: [],
                    fishingEquipment: [],
                    reservationCancellationConditions: null,
                    pictures: [],
                    additionalServices: []
                },
                tags: []
            }
        },
        computed: {
            nameIsValid() {
                return !!this.form.name;
            },
            descriptionIsValid() {
                return !!this.form.description;
            },
            countryIsValid() {
                return RegExp(/^[a-zA-Z.-]+(?:[\s-][/a-zA-Z.]+)*$/).test(this.form.country) && !!this.form.country;
            },
            cityIsValid() {
                return RegExp(/^[a-zA-Z.-]+(?:[\s-][/a-zA-Z.]+)*$/).test(this.form.city) && !!this.form.city;
            },
            addressIsValid() {
                return !!this.form.address;
            },
            typeIsValid() {
                return !!this.form.shipType;
            },
            lengthIsValid() {
                return typeof this.form.shipLength === 'number' && !!this.form.shipLength && this.form.shipLength > 5;
            },
            engineNumberIsValid() {
                return !!this.form.engineNumber;
            },
            enginePowerIsValid() {
                return typeof this.form.enginePower === 'number' && !!this.form.enginePower && this.form.enginePower > 40;
            },
            maxSpeedIsValid() {
                return RegExp(/[1-9][0-9](.*)km(\/|\\)(h)/).test(this.form.maxSpeed) && !!this.form.city;
            },
            capacityIsValid() {
                return  typeof this.form.capacity === 'number' && !!this.form.capacity && this.form.capacity > 0;
            },
            cancellationIsValid() {
                return !!this.form.reservationCancellationConditions;
            },
            priceIsValid() {
                return typeof this.form.price === 'number' && !!this.form.price && this.form.price > 0;
            },
            formIsValid() {
                return this.nameIsValid && this.descriptionIsValid && this.countryIsValid && this.cityIsValid && this.addressIsValid
                        && this.typeIsValid && this.lengthIsValid && this.engineNumberIsValid && this.enginePowerIsValid
                        && this.maxSpeedIsValid && this.capacityIsValid && this.cancellationIsValid && this.priceIsValid;
            }
        },
        methods: {
            addShip() {
                if (this.formIsValid) {
                    this.sendData();
                }
            },
            sendData() {
                axios.post("http://localhost:8088/ships/create-ship", {
                    name: this.form.name,
                    description: this.form.description,
                    country: this.form.country,
                    city: this.form.city,
                    street: this.form.address,
                    rulesOfConduct: this.form.rulesOfConduction,
                    type: this.form.shipType,
                    length: this.form.shipLength,
                    engineNum: this.form.engineNumber,
                    enginePower: this.form.enginePower,
                    maxSpeed: this.form.maxSpeed,
                    capacity: this.form.capacity,
                    navigationEquipment: this.form.navigationEquipment,
                    fishingEquipment: this.form.fishingEquipment,
                    reservationCancellationConditions: this.form.reservationCancellationConditions,
                    pictures: this.form.pictures,
                    price: this.form.price,
                    additionalServices: this.form.additionalServices
                }, {
                    headers: {
                        Authorization: 'Bearer ' + window.sessionStorage.getItem("accessToken")
                    }
                }).then(response => {
                    alert('Added ship: ' + response.data.name + '.');
                    router.back();
                }).catch(error => {
                    if (error.response.status === 400) alert("Server error.");
                    else alert("Error occurred while adding ship!");
                });
            },
            addPicture(e) {
                let files = e.target.files || e.dataTransfer.files;
                if (!files.length)
                    return;
                for (let file of files) this.form.pictures.push(file.name);
            }
        },
        mounted() {
            if (window.sessionStorage.getItem("role") === "ROLE_shipOwner") {
                axios.get("http://localhost:8088/tags/ship", {
                    headers: {
                        Authorization: 'Bearer ' + window.sessionStorage.getItem("accessToken")
                    }
                }).then((response) => {this.tags = response.data});
            }
            else {
                router.push("/");
            }
        }
    }
</script>