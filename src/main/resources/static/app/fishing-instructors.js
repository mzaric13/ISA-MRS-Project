Vue.component("fishing-instructors", {
    template: `
    <div>
        <guest-navbar></guest-navbar>
        <div class="d-flex" style="width:100%; height:100%; background-image: url('images/fishing_background.jpg');">
            <search-sidebar style="background-color: #ffffff;"></search-sidebar>
            <div style="width:50%;height:100%;margin:auto;margin-top:100px;">
                <div class="vertical-center">
                    <search-result></search-result>
                    <search-result></search-result>
                    <search-result></search-result>
                    <search-result></search-result>
                    <search-result></search-result>
                </div>
            </div>
        </div>
    </div>
    `,
})