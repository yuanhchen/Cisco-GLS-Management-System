
get_page_vlan_form = `

<label class="sr-only" for="vlan_id" > Vlan_ID </label>
<input type="text" class="form-control mb-2 mr-sm-2" id="vlan_id" name="vlan_id" placeholder="Enter vlan id">

`


get_page_rack_form = `
    <input type="text" class="form-control mb-2 mr-sm-2" id="building"  name="building" placeholder="Enter Building">
    <input type="text" class="form-control mb-2 mr-sm-2" id="lab"       name="lab"      placeholder="Enter Lab">
    <input type="text" class="form-control mb-2 mr-sm-2" id="row"       name="row"      placeholder="Enter Row">
    <input type="text" class="form-control mb-2 mr-sm-2" id="rack"      name="rack"     placeholder="Enter Rack">
`

function changeInputForm(radio) {
    if (radio.checked && radio.id === "vlanApi") {
        document.getElementById("inputform").innerHTML = get_page_vlan_form ;
    } else if (radio.checked && radio.id === "rackApi") {
        document.getElementById("inputform").innerHTML = get_page_rack_form
    }
 }


 add_page_vlan_form = `

 <label class="sr-only" for="vlan_id" > Vlan_ID </label>
 <input type="text" class="form-control mb-2 mr-sm-2" id="vlan_id"          name="vlan_id"          placeholder="Enter vlan id">
 
 <label class="sr-only" for="switch_location" > switch_location </label>
 <input type="text" class="form-control mb-2 mr-sm-2" id="switch_location"  name="switch_location"  placeholder="Enter switch_location">
 
 <label class="sr-only" for="subnet_ipv4" > subnet_ipv4 </label>
 <input type="text" class="form-control mb-2 mr-sm-2" id="subnet_ipv4"      name="subnet_ipv4"      placeholder="Enter subnet_ipv4">
 
 <label class="sr-only" for="subnet_ipv6" > subnet_ipv6 </label>
 <input type="text" class="form-control mb-2 mr-sm-2" id="subnet_ipv6"      name="subnet_ipv6"      placeholder="Enter subnet_ipv6">
 
 <label class="sr-only" for="gateway_ipv4" > gateway_ipv4 </label>
 <input type="text" class="form-control mb-2 mr-sm-2" id="gateway_ipv4"     name="gateway_ipv4"     placeholder="Enter gateway_ipv4">
 
 <label class="sr-only" for="gateway_ipv6" > gateway_ipv6 </label>
 <input type="text" class="form-control mb-2 mr-sm-2" id="gateway_ipv6"     name="gateway_ipv6"     placeholder="Enter gateway_ipv6">
 
 `

 add_page_rack_form = `
 <input type="text" class="form-control mb-2 mr-sm-2" id="building"                 name="building" placeholder="Enter Building">
 <input type="text" class="form-control mb-2 mr-sm-2" id="lab"                      name="lab"      placeholder="Enter Lab">
 <input type="text" class="form-control mb-2 mr-sm-2" id="row"                      name="row"      placeholder="Enter Row">
 <input type="text" class="form-control mb-2 mr-sm-2" id="rack"                     name="rack"     placeholder="Enter Rack">
 <input type="text" class="form-control mb-2 mr-sm-2" id="vlan_id"                  name="vlan_id"  placeholder="Enter vlan_id">
 <input type="text" class="form-control mb-2 mr-sm-2" id="reserved_rack_ip_ipv4"    name="ipv4"     placeholder="Enter ipv4">
 <input type="text" class="form-control mb-2 mr-sm-2" id="reserved_rack_ip_ipv6"    name="ipv6"     placeholder="Enter ipv6">
`

 function add_page_changeInputForm(radio) {
     if (radio.checked && radio.id === "vlanApi") {
         document.getElementById("inputform").innerHTML = add_page_vlan_form ;
     } else if (radio.checked && radio.id === "rackApi") {
         document.getElementById("inputform").innerHTML = add_page_rack_form
     }
  }