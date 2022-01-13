from flask import Blueprint, render_template, request, flash

import requests, json

views = Blueprint('views', __name__)

base_url = "http://localhost:8080/"
rack_url = base_url + "racks/"
vlan_url = base_url + "vlans/"

@views.route('/', methods=['GET', 'POST'])
def home():

    response = []
    selected_radio_btn = None

    if request.method == 'POST':

        selected_radio_btn = request.form.get('radioBtn')

        if selected_radio_btn == 'opt_vlan':
            response = requests.request("GET", vlan_url).json()
        elif selected_radio_btn == 'opt_rack':
            response = requests.request("GET", rack_url).json()

    return render_template("home.html", response=response )

@views.route('/get', methods=['GET', 'POST'])
def get():

    response = []
    selected_radio_btn = None
    checked = False

    if request.method == 'POST':

        selected_radio_btn = request.form.get('radioBtn')

        if selected_radio_btn == None:
            flash("Please select an API using the radio buttons", category="error")

        if selected_radio_btn == 'opt_vlan':
            
            if request.form.get("vlan_id") == "":
                flash("Please enter a vlan id", category="error")
            else:
                one_vlan_url = vlan_url + request.form.get("vlan_id")
                response = requests.request("GET", one_vlan_url).json()
                flash("Vlan information found!", category="success")
                checked=True

        elif selected_radio_btn == 'opt_rack':

            building = request.form.get("building")
            lab = request.form.get("lab")
            row = request.form.get("row")
            rack = request.form.get("rack")

            if building == "":
                flash("Please enter a building number", category="error")
            elif lab == "":
                flash("Please enter a lab number", category="error")
            elif row == "":
                flash("Please enter a row number", category="error")
            elif rack == "":
                flash("Please enter a rack number", category="error")
            else:
                url = rack_url + str(building) + "-" + str(lab) + "-" + str(row) + "-" + str(rack)

                response = requests.request("GET", url).json()
                flash("Rack information found!", category="success")
                checked=True

    return render_template("get.html", response=response, formChecked=checked)


@views.route('/add', methods=['GET', 'POST'])
def add():

    selected_radio_btn = None
    checked = False

    if request.method == 'POST':

        selected_radio_btn = request.form.get('radioBtn')

        if selected_radio_btn == None:  
            flash("Please select an API using the radio buttons", category="error")

        if selected_radio_btn == 'opt_vlan':

            vlan_id = request.form.get("vlan_id")
            switch_location = request.form.get("switch_location")
            subnet_ipv4 = request.form.get("subnet_ipv4")
            subnet_ipv6 = request.form.get("subnet_ipv6")
            gateway_ipv4 = request.form.get("gateway_ipv4")
            gateway_ipv6 = request.form.get("gateway_ipv6")

            if vlan_id == "":
                flash("Please enter a vlan_id", category="error")
            else:
                # create the dictionary
                dictionary = {
                    "vlan_id": vlan_id
                }

                if switch_location != "":
                    dictionary["switch_location"] = switch_location
                if subnet_ipv4 != "":
                    dictionary["subnet_ipv4"] = subnet_ipv4
                if subnet_ipv6 != "":
                    dictionary["subnet_ipv6"] = subnet_ipv6
                if gateway_ipv4 != "":
                    dictionary["gateway_ipv4"] = gateway_ipv4
                if gateway_ipv6 != "":
                    dictionary["gateway_ipv6"] = gateway_ipv6

                # assign user data to payload

                payload = json.dumps(dictionary)

                headers = {
                    'Content-Type': 'application/json'
                }

                response = requests.request("POST", vlan_url, headers=headers, data=payload)

                if response.status_code == 200:                    
                    flash("Vlan information added!", category="success")
                    checked=True
                else:
                    flash("Something went wrong during the post request", category="error")

        elif selected_radio_btn == 'opt_rack':

            building = request.form.get("building")
            lab = request.form.get("lab")
            row = request.form.get("row")
            rack = request.form.get("rack")
            vlan_id = request.form.get("vlan_id")
            ipv4 = request.form.get("ipv4")
            ipv6 = request.form.get("ipv6")

            if building == "":
                flash("Please enter a building number", category="error")
            elif lab == "":
                flash("Please enter a lab number", category="error")
            elif row == "":
                flash("Please enter a row number", category="error")
            elif rack == "":
                flash("Please enter a rack number", category="error")
            
            else:
                # create the dictionary
                dictionary = {
                    "id": {
                        "building": building,
                        "lab": lab,
                        "row_num": row,
                        "rack_num": rack
                    }
                }

                if vlan_id != "":
                    dictionary["vlan_id"] = vlan_id
                if ipv4 != "":
                    dictionary["reserved_rack_ip_ipv4"] = ipv4
                if ipv6 != "":
                    dictionary["reserved_rack_ip_ipv6"] = ipv6

                # assign data to payload

                payload = json.dumps(dictionary)

                headers = {
                    'Content-Type': 'application/json'
                }

                response = requests.request("POST", rack_url, headers=headers, data=payload)

                if response.status_code == 200:                    
                    flash("Rack information added!", category="success")
                    checked=True
                else:
                    flash("Something went wrong during the post request", category="error")

    return render_template("add.html")



@views.route('/update', methods=['GET', 'POST'])
def update():

    selected_radio_btn = None
    checked = False

    if request.method == 'POST':
        selected_radio_btn = request.form.get('radioBtn')

        if selected_radio_btn == None:  
            flash("Please select an API using the radio buttons", category="error")    
     
        if selected_radio_btn == 'opt_vlan':

            # Assign all user inputs to meaningful variable names
            vlan_id         = request.form.get("vlan_id")
            switch_location = request.form.get("switch_location")
            subnet_ipv4     = request.form.get("subnet_ipv4")
            subnet_ipv6     = request.form.get("subnet_ipv6")
            gateway_ipv4    = request.form.get("gateway_ipv4")
            gateway_ipv6    = request.form.get("gateway_ipv6")

            if vlan_id == "":
                flash("Please enter a vlan_id", category="error")
            else:

                data_on_record = requests.request("GET", vlan_url + vlan_id ).json()
                print(data_on_record)

                # create the dictionary
                dictionary = {
                }

                # set up the user input
                if switch_location != "":
                    dictionary["switch_location"] = switch_location
                else:
                    dictionary["switch_location"] = data_on_record["switch_location"]
                    
                if subnet_ipv4 != "":
                    # remember to update the "previous_subnet_ipv4" field
                    dictionary["previous_subnet_ipv4"] = data_on_record["subnet_ipv4"]
                    dictionary["subnet_ipv4"] = subnet_ipv4
                else:
                    dictionary["subnet_ipv4"] = data_on_record["subnet_ipv4"]
                    # no change on current ipv4 means no change for previous ipv4
                    dictionary["previous_subnet_ipv4"] = data_on_record["previous_subnet_ipv4"]
                    
                if subnet_ipv6 != "":
                    dictionary["subnet_ipv6"] = subnet_ipv6
                else:
                    dictionary["subnet_ipv6"] = data_on_record["subnet_ipv6"]
                    
                if gateway_ipv4 != "":
                    # remember to update the "previous_gateway_ipv4" field
                    dictionary["previous_gateway_ipv4"] = data_on_record["gateway_ipv4"]
                    dictionary["gateway_ipv4"] = gateway_ipv4
                else:
                    dictionary["gateway_ipv4"] = data_on_record["gateway_ipv4"]
                    # no change on current ipv4 means no change for previoius ipv4
                    dictionary["previous_gateway_ipv4"] = data_on_record["previous_gateway_ipv4"]
                    
                if gateway_ipv6 != "":
                    dictionary["gateway_ipv6"] = gateway_ipv6
                else:
                    dictionary["gateway_ipv6"] = data_on_record["gateway_ipv6"]
                    

                # assign user data to payload

                payload = json.dumps(dictionary)

                headers = {
                    'Content-Type': 'application/json'
                }

                response = requests.request("PUT", vlan_url + vlan_id, headers=headers, data=payload)

                if response.status_code == 200:                    
                    flash("Vlan information updated!", category="success")
                    checked=True
                else:
                    flash("Something went wrong during the put request", category="error")

        elif selected_radio_btn == 'opt_rack':

            building = request.form.get("building")
            lab = request.form.get("lab")
            row = request.form.get("row")
            rack = request.form.get("rack")

            rack_id = building + "-" + lab + "-" + row + "-" + rack 

            vlan_id = request.form.get("vlan_id")
            ipv4 = request.form.get("ipv4")
            ipv6 = request.form.get("ipv6")
            

            if building == "":
                flash("Please enter a building number", category="error")
            elif lab == "":
                flash("Please enter a lab number", category="error")
            elif row == "":
                flash("Please enter a row number", category="error")
            elif rack == "":
                flash("Please enter a rack number", category="error")
            
            else:
                
                data_on_record = requests.request("GET", rack_url + rack_id ).json()
                
                # create the dictionary
                dictionary = {
                }

                if vlan_id != "":
                    dictionary["vlan_id"] = vlan_id
                else:
                    dictionary["vlan_id"] = data_on_record["vlan_id"]
                if ipv4 != "":
                    dictionary["reserved_rack_ip_ipv4"] = ipv4
                    dictionary["previous_reserved_rack_ip_ipv4"] = data_on_record["reserved_rack_ip_ipv4"]
                else:
                    # remeber to update the "previous_reserved_rack_ip_ipv4" field
                    dictionary["previous_reserved_rack_ip_ipv4"] = data_on_record["previous_reserved_rack_ip_ipv4"]
                    dictionary["reserved_rack_ip_ipv4"] =  data_on_record["reserved_rack_ip_ipv4"]
                if ipv6 != "":
                    dictionary["reserved_rack_ip_ipv6"] = ipv6
                else:
                    dictionary["reserved_rack_ip_ipv6"] = data_on_record["reserved_rack_ip_ipv6"]

                # assign data to payload

                url = rack_url + rack_id

                payload = json.dumps(dictionary)

                headers = {
                    'Content-Type': 'application/json'
                }

                response = requests.request("PUT", url, headers=headers, data=payload)

                if response.status_code == 200:                    
                    flash("Rack information added!", category="success")
                    checked=True
                else:
                    flash("Something went wrong during the put request", category="error")

    return render_template("update.html")


@views.route('/delete', methods=['GET', 'POST'])
def delete():

    selected_radio_btn = None

    if request.method == 'POST':

        selected_radio_btn = request.form.get('radioBtn')

        if selected_radio_btn == None:  
            flash("Please select an API using the radio buttons", category="error")    

        if selected_radio_btn == 'opt_vlan':
            
            vlan_id = request.form.get("vlan_id")

            response = requests.request("DELETE", vlan_url + vlan_id)
            
            if response.status_code == 200: 
                flash("Vlan deleted!", category="success")
            else:
                flash("Server error", category="error")

        elif selected_radio_btn == 'opt_rack':

            building = request.form.get("building")
            lab = request.form.get("lab")
            row = request.form.get("row")
            rack = request.form.get("rack")

            url = rack_url + str(building) + "-" + str(lab) + "-" + str(row) + "-" + str(rack)
            
            response = requests.request("DELETE", url)

            if response.status_code == 200: 
                flash("Rack deleted!", category="success")
            else:
                flash("Server error", category="error")

    return render_template("delete.html")

@views.route('/starter', methods=['GET', 'POST'])
def starter():

    return render_template("starter.html")