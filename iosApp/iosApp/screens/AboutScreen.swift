//
//  AboutScreen.swift
//  iosApp
//
//  Created by Shota Sakaguchi on 2024/04/30.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct AboutScreen: View {
    @Environment(\.dismiss)
    private var dismiss
    
    var body: some View {
        NavigationStack {
            AboutListView().navigationTitle("About Device")
                .toolbar {
                    Button {
                        dismiss()
                    } label: {
                        Text("Done").bold()
                    }
                }
        }
    }
}

#Preview {
    AboutScreen()
}
